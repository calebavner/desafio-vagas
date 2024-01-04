package placeservice.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import placeservice.api.PlaceRequest;
import placeservice.api.PlaceResponse;
import placeservice.domain.PlaceService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

  private final PlaceService service;

  public PlaceController(PlaceService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Mono<PlaceResponse>> create(@RequestBody @Valid PlaceRequest p) {
    var response = service.create(p).map(PlaceMapper::placeToResponse);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
 }
