package com.example.test_from_chmykhalov.service;

import java.util.concurrent.CopyOnWriteArrayList;

public interface TestService {
    CopyOnWriteArrayList<CopyOnWriteArrayList<String>> processingAndJoining(CopyOnWriteArrayList<CopyOnWriteArrayList<String>> inputArray);
}
