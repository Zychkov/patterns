package ru.zychkov.web.servicelocator.example1;

import java.util.ArrayList;
import java.util.List;

public class ServiceLocatorMain {

    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
    }
}

interface Service {
    String getName();

    void execute();
}

class Service1 implements Service {

    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing service1");
    }
}

class Service2 implements Service {

    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing service2");
    }
}

class InitialContext {

    public Object lookup(String jndiName) {
        if (jndiName.equalsIgnoreCase("SERVICE1")) {
            return new Service1();
        } else if (jndiName.equalsIgnoreCase("SERVICE2")) {
            return new Service2();
        }

        return null;
    }
}

class Cache {
    private List<Service> services = new ArrayList<>();

    public Service getService(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached + " + serviceName + " object");
                return service;
            }
        }

        return null;
    }

    public void addService(Service newService) {
        boolean exists = false;
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
        }

        if (!exists) {
            services.add(newService);
        }
    }
}

class ServiceLocator {
    private static Cache cache = new Cache();;

    public static Service getService(String jndi) {
        Service service = cache.getService(jndi);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndi);
        cache.addService(service1);

        return service1;
    }
}