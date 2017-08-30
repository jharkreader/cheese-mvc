package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.data.repository.CrudRepository;

public interface CheeseDao extends CrudRepository<Cheese, Integer> {

}
