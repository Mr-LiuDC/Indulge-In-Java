package springboot.repositroy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Comment;

public interface CommentRepositroy extends JpaRepository<Comment, Long> {

	Page<Comment> findCommentsByContentContains(String content, Pageable pageable);

	Page<Comment> findCommentsByArticle_Id(Long articleId, Pageable pageable);

}
