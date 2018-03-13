package springboot.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springboot.domain.Article;
import springboot.domain.User;
import springboot.repositroy.ArticleRepositroy;
import springboot.repositroy.UserRepositroy;

/**
 * 文章操作API
 * 
 * @author LiuDeCai
 *
 */
@RestController
@RequestMapping(value = "/api/article")
@Api("文章操作接口")
public class ArticleApi {

	@Autowired
	private ArticleRepositroy articleRepositroy;
	@Autowired
	private UserRepositroy userRepositroy;

	/**
	 * 新增文章信息
	 * 
	 * @param title
	 * @param content
	 * @param userId
	 * @return
	 */
	@PostMapping()
	@ApiOperation(value = "新增文章", notes = "新增文章信息")
	public ModelMap saveArticle(@RequestParam String title, @RequestParam String content, @RequestParam String userId) {
		ModelMap modelMap = new ModelMap();
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		User user = userRepositroy.getOne(Long.parseLong(userId));
		article.setUser(user);
		Article saveResult = articleRepositroy.save(article);
		if (saveResult != null) {
			modelMap.addAttribute("message", "成功添加文章");
			modelMap.addAttribute("article", saveResult);
		} else {
			modelMap.addAttribute("message", "添加文章失败");
		}
		return modelMap;
	}

	/**
	 * 根据文章ID删除文章信息
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	@ApiOperation(value = "删除文章", notes = "根据ID删除文章信息")
	public ModelMap deleteArticleById(@PathVariable String id) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			Article article = articleRepositroy.findOne(idNum);
			if (article == null) {
				modelMap.addAttribute("message", "要删除的文章不存在");
			}
			articleRepositroy.delete(article);
			return modelMap.addAttribute("message", "成功删除文章");
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 根据ID更新文章信息
	 * 
	 * @param id
	 * @param title
	 * @param content
	 * @return
	 */
	@PutMapping("{id}")
	@ApiOperation(value = "更新文章", notes = "更新文章信息")
	public ModelMap updateArticleById(@PathVariable String id, @RequestParam String title,
			@RequestParam String content) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			Article article = articleRepositroy.findOne(idNum);
			if (article == null) {
				modelMap.addAttribute("message", "要更新的文章不存在");
			}
			article.setTitle(title);
			article.setContent(content);
			Article saveResult = articleRepositroy.save(article);
			if (saveResult != null) {
				modelMap.addAttribute("message", "成功更新文章信息");
				modelMap.addAttribute("article", saveResult);
			} else {
				modelMap.addAttribute("message", "更新文章信息失败");
			}
			return modelMap;
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 根据ID查询文章信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	@ApiOperation(value = "查询文章", notes = "根据ID查询文章信息")
	public ModelMap getArticleById(@PathVariable String id) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			Article article = articleRepositroy.findOne(idNum);
			if (article == null) {
				modelMap.addAttribute("message", "要查询的文章不存在");
			}
			return modelMap.addAttribute("article", article);
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 分页查询文章信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "分页查询文章", notes = "分页查询文章信息")
	public ModelMap listUserPage(@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSizeStr) {
		ModelMap modelMap = new ModelMap();
		int pageNo = 1;
		int pageSize = Integer.parseInt(pageSizeStr);
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 0) {
				pageNo = 0;
			}
		} catch (Exception e) {
		}

		PageRequest pageable = new PageRequest(pageNo, pageSize);
		Page<Article> articlePage = articleRepositroy.findAll(pageable);
		modelMap.addAttribute("page", articlePage);
		return modelMap;
	}

	/**
	 * 按文章名条件分页查询文章信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param keyWord
	 * @return
	 */
	@GetMapping("p")
	@ApiOperation(value = "条件查询文章", notes = "按文章名条件分页查询文章信息")
	public ModelMap listUserPageByParameter(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSizeStr,
			@RequestParam(value = "keyWord", required = false, defaultValue = "") String keyWord) {
		ModelMap modelMap = new ModelMap();
		int pageNo = 1;
		int pageSize = Integer.parseInt(pageSizeStr);
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 0) {
				pageNo = 0;
			}
		} catch (Exception e) {
		}

		PageRequest pageable = new PageRequest(pageNo, pageSize);
		Page<Article> articlePage = articleRepositroy.findArticlesByTitleContainsOrContentContains(keyWord, pageable);
		modelMap.addAttribute("page", articlePage);
		return modelMap;
	}

}
