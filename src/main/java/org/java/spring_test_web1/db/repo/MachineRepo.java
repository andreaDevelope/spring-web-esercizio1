package org.java.spring_test_web1.db.repo;

import org.java.spring_test_web1.db.pojo.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Integer>{

}
