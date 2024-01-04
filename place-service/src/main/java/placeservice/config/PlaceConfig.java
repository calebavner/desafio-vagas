package placeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import placeservice.domain.PlaceRepository;
import placeservice.domain.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

  @Bean
  PlaceService placeService(PlaceRepository repo) {
    return new PlaceService(repo);
  }
}
