package com.example.final_project_shop.shape.observer;

public interface Observed {
    void attach(CustomerObserver observer);

    void detach(CustomerObserver observer);

    void notifyObservers();
}
