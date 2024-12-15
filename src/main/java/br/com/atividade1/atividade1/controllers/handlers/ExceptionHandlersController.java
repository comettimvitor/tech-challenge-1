package br.com.atividade1.atividade1.controllers.handlers;

import br.com.atividade1.atividade1.dtos.exceptionsDTO.CadastroExistenteDTO;
import br.com.atividade1.atividade1.dtos.exceptionsDTO.ResourceNotFoundDTO;
import br.com.atividade1.atividade1.services.exceptions.CadastroExistenteException;
import br.com.atividade1.atividade1.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlersController {

    @ExceptionHandler(CadastroExistenteException.class)
    public ResponseEntity<CadastroExistenteDTO> handlerCadastroExistenteException(CadastroExistenteException ex) {
        var status = HttpStatus.CONFLICT;
        return ResponseEntity.status(status.value()).body(new CadastroExistenteDTO(ex.getMessage(), status.value()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDTO> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status.value()).body(new ResourceNotFoundDTO(ex.getMessage(), status.value()));
    }
}
