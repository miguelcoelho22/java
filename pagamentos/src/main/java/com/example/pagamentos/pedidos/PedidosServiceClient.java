package com.example.pagamentos.pedidos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name= "pedidos", url=http/)
public interface PedidosServiceClient {

    @PutMapping("/{id}/pago")
    void pago(@PathVariable Long id){}

}
