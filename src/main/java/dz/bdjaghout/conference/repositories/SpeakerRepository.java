package dz.bdjaghout.conference.repositories;

import dz.bdjaghout.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
