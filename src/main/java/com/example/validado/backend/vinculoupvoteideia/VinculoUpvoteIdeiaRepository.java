package com.example.validado.backend.vinculoupvoteideia;

import com.example.validado.backend.ideia.IdeiaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinculoUpvoteIdeiaRepository extends JpaRepository<IdeiaModel, Long> {
}
