package springboot.repositroy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Article;

/**
 * ArticleRepository
 * 
 * @author LiuDeCai
 * @date 2018/04/06
 *
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

	/**
	 * 根据标题或内容分页查询
	 * 
	 * @param title
	 * @param content
	 * @param pageable
	 * @return
	 */
	Page<Article> findArticlesByTitleContainingAndContentContaining(String title, String content, Pageable pageable);

}
