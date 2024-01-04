package placeservice.domain;

import com.github.slugify.Slugify;
import placeservice.api.PlaceRequest;
import reactor.core.publisher.Mono;

public class PlaceService {

  private final PlaceRepository repo;
  private final Slugify slg;

  public PlaceService(PlaceRepository repo) {
    this.repo = repo;
    this.slg = Slugify.builder().build();
  }

  public Mono<Place> create(PlaceRequest p) {
    var place = new Place(null, p.name(), slg.slugify(p.name()), p.state(), null, null);
    return repo.save(place);
  }
}
