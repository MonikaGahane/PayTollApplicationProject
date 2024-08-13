package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
import com.app.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
	Optional<Wallet> findByUserID(User user);
}
