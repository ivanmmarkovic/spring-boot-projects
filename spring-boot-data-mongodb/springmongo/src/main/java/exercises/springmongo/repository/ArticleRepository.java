package exercises.springmongo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import exercises.springmongo.entity.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String> {

}
