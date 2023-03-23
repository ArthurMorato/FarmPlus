package com.arthurmorato.farmplus.repository;

import java.util.Optional;

import com.arthurmorato.gadoplus.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(String email); // busca um usuário pelo email

    Optional<UsuarioEntity> findByNomeAndSenha(String nome, String senha); // busca um usuário pelo nome e senha

    boolean existsByEmail(String email); // verifica se um usuário com o email especificado existe

    boolean existsByNome(String nome); // verifica se um usuário com o nome especificado existe

}

