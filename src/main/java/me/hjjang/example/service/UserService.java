package me.hjjang.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hjjang.example.domain.User;
import me.hjjang.example.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final HistoryService historyService;

    @Transactional
    public void userSave(String userName, int age) {
        log.info("UserService.userSave --- start");
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());
        userRepository.save(user);
        try {
            historyService.saveHistory(user.getUserName());
        }catch (Exception e){
            log.error("Error",e);
        }




        log.info("UserService.userSave --- end");
    }
}
