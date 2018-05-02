package springboot.repositroy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Comment;

/**
 * CommentRepository
 * 
 * @author LiuDeCai
 * @date 2018/04/06
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

	/**
	 * 根据关键字分页查询
	 * 
	 * @param content
	 * @param pageable
	 * @return
	 */
	Page<Comment> findCommentsByContentContains(String content, Pageable pageable);

	/**
	 * 根据文章ID分页查询留言评论
	 * 
	 * @param articleId
	 * @param pageable
	 * @return
	 */
	Page<Comment> findCommentsByArticleId(Long articleId, Pageable pageable);

}
