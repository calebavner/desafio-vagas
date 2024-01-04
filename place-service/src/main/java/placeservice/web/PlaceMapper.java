package placeservice.web;

import placeservice.api.PlaceResponse;
import placeservice.domain.Place;

public class PlaceMapper {

  public static PlaceResponse placeToResponse(Place p) {
    return new PlaceResponse(p.name(), p.slug(), p.state(), p.createdAt(), p.updatedAt());
  }
}
