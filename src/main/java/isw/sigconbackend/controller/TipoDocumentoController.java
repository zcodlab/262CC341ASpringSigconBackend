package isw.sigconbackend.controller;

import isw.sigconbackend.repository.TipoDocumentoRepository;
import isw.sigconbackend.service.TipoDocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/tipodocumento")
public class TipoDocumentoController {
    private final Logger logger = LoggerFactory.getLogger(TipoDocumentoController.class);

    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public ResponseEntity<?> getTipoDocumento(){
        try{
            return ResponseEntity.ok(tipoDocumentoService.getTipoDocumento());
        }catch (Exception e)
        {   logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
