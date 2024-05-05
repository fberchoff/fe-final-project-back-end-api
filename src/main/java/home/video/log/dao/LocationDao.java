package home.video.log.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import home.video.log.entity.File;
import home.video.log.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {
	
@Query("SELECT location " +
       "FROM Location location " +
	   "WHERE location.locationType.project.user.userName = :userName " +
       "  AND location.locationType.project.projectId = :projectId")
List<Location> findAllByUserNameAndProjectId(
		@Param("userName") String userName,
		@Param("projectId") Long projectId);

}
