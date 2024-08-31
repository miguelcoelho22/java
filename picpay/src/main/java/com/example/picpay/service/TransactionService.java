package com.example.picpay.service;

import com.example.picpay.domain.Transaction;
import com.example.picpay.domain.TransactionDto;
import com.example.picpay.domain.User;
import com.example.picpay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService service;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Transaction createTransaction(TransactionDto dto) throws Exception {
        User sender = service.findUserById(dto.senderId());
        User receiver = service.findUserById(dto.receiverId());

        service.validarTransacao(sender, dto.amount());

        if(!autorizacaoTransacao()) {
            throw new Exception("transacao nao autorizada");
        }

        Transaction transaction = new Transaction();
        transaction.setReceiver(receiver);
        transaction.setSender(sender);
        transaction.setTimeStamp(LocalDateTime.now());
        transaction.setAmount(dto.amount());

        sender.setBalance(sender.getBalance().subtract(dto.amount()));
        receiver.setBalance(receiver.getBalance().add(dto.amount()));

        repository.save(transaction);
        service.savaUser(sender);
        service.savaUser(receiver);

        return transaction;
    }

    public Boolean autorizacaoTransacao () {
        ResponseEntity<Map> authorizacaoResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if(authorizacaoResponse.getStatusCode() == HttpStatus.OK && authorizacaoResponse.getBody().get("status") == "sucess"){
            return true;
        }else return false;
    }
}
