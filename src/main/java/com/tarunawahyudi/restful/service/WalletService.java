package com.tarunawahyudi.restful.service;

import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.entity.Wallet;
import com.tarunawahyudi.restful.model.CreateWalletRequest;
import com.tarunawahyudi.restful.model.WalletResponse;
import com.tarunawahyudi.restful.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService {

    private final ValidationService validator;
    private final WalletRepository walletRepository;

    public WalletService(ValidationService validator, WalletRepository walletRepository) {
        this.validator = validator;
        this.walletRepository = walletRepository;
    }

    public WalletResponse create(User user, CreateWalletRequest request) {
        validator.validate(request);

        Wallet wallet = new Wallet();
        wallet.setName(request.getName());
        wallet.setBalance(request.getBalance());
        wallet.setUserId(request.getUserId());

        walletRepository.save(wallet);

        return convertToWalletResponse(wallet);
    }

    public List<WalletResponse> show() {
        List<Wallet> wallets = walletRepository.getAll();
        return wallets.stream()
                .map(this::convertToWalletResponse)
                .collect(Collectors.toList());
    }

    public WalletResponse get(int id) {
        Wallet wallet = walletRepository.getById(id);
        return convertToWalletResponse(wallet);
    }

    public WalletResponse update(CreateWalletRequest request, int id) {
        validator.validate(request);

        Wallet wallet = new Wallet();
        wallet.setName(request.getName());
        wallet.setBalance(request.getBalance());
        wallet.setUserId(request.getUserId());

        walletRepository.update(wallet, id);

        return convertToWalletResponse(wallet);
    }

    public void remove(int id) {
        walletRepository.delete(id);
    }

    private WalletResponse convertToWalletResponse(Wallet wallet) {
        return WalletResponse.builder()
                .name(wallet.getName())
                .balance(wallet.getBalance())
                .userId(wallet.getUserId())
                .build();
    }


}
