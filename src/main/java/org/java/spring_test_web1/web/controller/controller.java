package org.java.spring_test_web1.web.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring_test_web1.db.pojo.Machine;
import org.java.spring_test_web1.db.service.MachineService;
import org.java.spring_test_web1.web.controller.dto.MachineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("machine")

public class controller {
    @Autowired
    MachineService ms;
    
    @GetMapping("add")
    public ResponseEntity<Void> addTestMachine(){
        Machine m1 = new Machine("Mito", "una bella macchina", 1800000);
        Machine m2 = new Machine("Corsa", "una macchina discreta", 1300000);
        Machine m3 = new Machine("Mastang", "una macchina unica", 2800000);

        ms.save(m1);
        ms.save(m2);
        ms.save(m3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Machine>> getAllMachine(){

        List<Machine> machines = ms.getAll();
        return ResponseEntity.ok(machines);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        Optional<Machine> optM = ms.getMachineById(id);
        if (optM.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Machine m = optM.get();
        ms.delete(m);
        return ResponseEntity.ok("Deleted machine (id: " + id + ")");
    }

    @PostMapping("create")
    public ResponseEntity<Machine> addMachine(@RequestBody MachineDto machineDto) {
        Machine machine = new Machine(machineDto.getName(), machineDto.getDescription(), machineDto.getPrice());
        ms.save(machine);
        return ResponseEntity.ok(machine);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Machine> upDateMachine(@PathVariable int id, @RequestBody MachineDto md){
        Optional<Machine> optMachine = ms.getMachineById(id);

        if (optMachine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
    
        Machine m = optMachine.get();
    
        if (md.getName() != null && !md.getName().isEmpty()) {
            m.setName(md.getName());
        }
    
        if (md.getDescription() != null && !md.getDescription().isEmpty()) {
            m.setDescription(md.getDescription());
        }
    
        if (md.getPrice() != -1 || md.getPrice() != 0 ) {
            m.setPrice(md.getPrice());
        }
    
        ms.save(m);
    
        return ResponseEntity.ok(m);
    }
}
