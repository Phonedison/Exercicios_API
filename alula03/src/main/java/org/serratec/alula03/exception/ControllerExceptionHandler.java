package org.serratec.alula03.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override // -> tratativa para erros 400
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> erros = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            erros.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(
                status.value(),
                "Existem Campos Inválidos, Confira o preenchimento",
                LocalDateTime.now(), erros);

        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);

    }

    @ExceptionHandler(RecursoNaoEncontradoException.class) // -> tratativa para erros 404
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex, HttpHeaders headers,
            WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND; // preparando o status para a Resposta 404

        ErroResposta erroResposta = new ErroResposta( // -> Montando objeto
                status.value(), // -> valor 404 not found (passado acima)
                ex.getMessage(), // -> usa a mensagem passada nos throws
                LocalDateTime.now(),
                null // -> nullo pois não lista de erro
        );

        return handleExceptionInternal(ex, erroResposta, headers, status, request);
    }
}
