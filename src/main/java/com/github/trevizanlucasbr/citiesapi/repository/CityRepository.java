package com.github.trevizanlucasbr.citiesapi.repository;

import com.github.trevizanlucasbr.citiesapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {

    String QUERY = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> "
            + "(SELECT lat_lon FROM cidade WHERE id=?2)) as distance";

    @Query(value = QUERY, nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);


    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(double x, double y, double x1, double y1);
}
