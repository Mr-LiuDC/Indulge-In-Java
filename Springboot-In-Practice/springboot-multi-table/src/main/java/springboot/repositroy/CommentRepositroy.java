package springboot.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Comment;

public interface CommentRepositroy extends JpaRepository<Comment, Long> {

}
