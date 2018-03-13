package springboot.repositroy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Article;

public interface ArticleRepositroy extends JpaRepository<Article, Long> {

	Page<Article> findArticlesByTitleContainsOrContentContains(String keyWord, PageRequest pageable);

}
