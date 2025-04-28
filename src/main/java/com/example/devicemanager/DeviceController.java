package com.example.devicemanager;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    
    private List<Device> devices = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    // GET /devices -> list all devices
    @GetMapping
    public List<Device> getAllDevices() {
        return devices;
    }

    // POST /devices -> add a new device
    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        device.setId(idCounter.incrementAndGet());
        devices.add(device);
        return device;
    }
}