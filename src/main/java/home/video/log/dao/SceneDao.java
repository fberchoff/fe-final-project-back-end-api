package home.video.log.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import home.video.log.entity.File;
import home.video.log.entity.Scene;

public interface SceneDao extends JpaRepository<Scene, Long> {
	
	Set<Scene> findAllBySceneIdIn(Set<Long> sceneIds);
	
	@Query("SELECT scene " +
	       "FROM Scene scene " +
		   "WHERE scene.location.locationType.project.user.userName = :userName " +
	       "  AND scene.location.locationType.project.projectId = :projectId")
	List<Scene> findAllByUserNameAndProjectId(
			@Param("userName") String userName,
			@Param("projectId") Long projectId);
	}
