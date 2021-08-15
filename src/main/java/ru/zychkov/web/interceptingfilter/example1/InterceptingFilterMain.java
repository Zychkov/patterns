package ru.zychkov.web.interceptingfilter.example1;

import java.util.ArrayList;
import java.util.List;

public class InterceptingFilterMain {

    static FilterManager filterManager = new FilterManager();

    static {
        filterManager.setFilter(new AuthFilter());
        filterManager.setFilter(new IpFilter());
    }

    public static void main(String[] args) {
        filterManager.filterRequest("say hello");
    }
}

interface Filter {

    void execute(String data);
}

class AuthFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("auth filter data " + request);
    }
}

class IpFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("ip filter data " + request);
    }
}

class FilterChain {
    List<Filter> filterList = new ArrayList<>();
    Target target = new Target();

    void addFilter(Filter filter) {
        filterList.add(filter);
    }

    void filter(String request) {
        for (Filter filter: filterList) {
            filter.execute(request);
        }

        target.doJob(request);
    }
}

class FilterManager {
    FilterChain filterChain = new FilterChain();

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.filter(request);
    }
}

class Target {
    void doJob(String request) {
        System.out.println("data came in: " + request);
    }
}