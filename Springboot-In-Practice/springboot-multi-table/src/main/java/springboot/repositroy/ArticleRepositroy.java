package springboot.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.domain.Article;

public interface ArticleRepositroy extends JpaRepository<Article, Long> {

}
