package org.java.spring_test_web1.db.service;

import java.util.List;
import java.util.Optional;

import org.java.spring_test_web1.db.pojo.Machine;
import org.java.spring_test_web1.db.repo.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {
    @Autowired
    private MachineRepo mr;

    public List<Machine> getAll(){
        return mr.findAll();
    }

    public Optional<Machine> getMachineById(int id){
        return mr.findById(id);
    }

    public void save(Machine m){
        mr.save(m);
    }

    public void delete(Machine m){
        mr.delete(m);
    }

}
