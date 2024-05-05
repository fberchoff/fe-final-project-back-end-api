package home.video.log.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import home.video.log.entity.Actor;
import home.video.log.entity.StorageLocation;

public interface ActorDao extends JpaRepository<Actor, Long> {
	
	Set<Actor> findAllByActorIdIn(Set<Long> actorIds);
	
	@Query("SELECT actor " +
	       "FROM Actor actor " +
		   "WHERE actor.project.user.userName = :userName " +
	       "  AND actor.project.projectId = :projectId")
	List<Actor> findAllByUserNameAndProjectId(
			@Param("userName") String userName,
			@Param("projectId") Long projectId);

}
