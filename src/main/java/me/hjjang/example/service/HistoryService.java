package me.hjjang.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hjjang.example.domain.History;
import me.hjjang.example.exception.ForceThrowException;
import me.hjjang.example.repository.HistoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ForceThrowException.class)
    public void saveHistory(String saveUserName) {
        log.info("HistoryService.saveHistory --- start");
        History history = new History();
        history.setUserName(saveUserName);
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        historyRepository.save(history);
        log.error("######### ForceThrow ############");
        throw new ForceThrowException("히스토리익셉션발생!");
    }
}
