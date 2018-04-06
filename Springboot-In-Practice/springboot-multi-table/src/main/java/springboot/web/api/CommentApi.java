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
import springboot.domain.Comment;
import springboot.domain.User;
import springboot.repositroy.ArticleRepositroy;
import springboot.repositroy.CommentRepositroy;
import springboot.repositroy.UserRepositroy;

/**
 * 留言评论API
 * 
 * @author LiuDeCai
 * @date 2018/04/06
 *
 */
@RestController
@RequestMapping(value = "/api/comment")
@Api("评论操作接口")
public class CommentApi {

	@Autowired
	private CommentRepositroy commentRepositroy;
	@Autowired
	private ArticleRepositroy articleRepositroy;
	@Autowired
	private UserRepositroy userRepositroy;

	/**
	 * 新增评论信息
	 * 
	 * @param name
	 * @param password
	 * @param modelMap
	 * @return
	 */
	@PostMapping()
	@ApiOperation(value = "新增评论", notes = "新增评论信息")
	public ModelMap savecomment(@RequestParam String content, @RequestParam(required = false) String parentCommentId,
			@RequestParam String articleId, @RequestParam String userId) {
		ModelMap modelMap = new ModelMap();
		Comment comment = new Comment();
		comment.setContent(content);

		Article article = articleRepositroy.getOne(Long.parseLong(articleId));
		comment.setArticle(article);
		Comment parentComment;
		if (parentCommentId != null) {
			parentComment = commentRepositroy.getOne(Long.parseLong(parentCommentId));
			comment.setComment(parentComment);
		}
		User user = userRepositroy.getOne(Long.parseLong(userId));
		comment.setUser(user);
		Comment saveResult = commentRepositroy.save(comment);
		if (saveResult != null) {
			modelMap.addAttribute("message", "成功添加评论信息");
			modelMap.addAttribute("comment", saveResult);
		} else {
			modelMap.addAttribute("message", "添加评论信息失败");
		}
		return modelMap;
	}

	/**
	 * 根据ID删除评论信息
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@DeleteMapping("{id}")
	@ApiOperation(value = "删除评论", notes = "删除评论信息")
	public ModelMap deletecommentById(@PathVariable String id) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			Comment comment = commentRepositroy.findOne(idNum);
			if (comment == null) {
				modelMap.addAttribute("message", "要删除的评论不存在");
			}
			commentRepositroy.delete(comment);
			return modelMap.addAttribute("message", "成功删除评论");
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 根据ID更新评论信息
	 * 
	 * @param id
	 * @param name
	 * @param password
	 * @param modelMap
	 * @return
	 */
	@PutMapping("{id}")
	@ApiOperation(value = "更新评论", notes = "更新评论信息")
	public ModelMap updatecommentById(@PathVariable String id, @RequestParam String content) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			Comment comment = commentRepositroy.findOne(idNum);
			if (comment == null) {
				modelMap.addAttribute("message", "要更新的评论不存在");
			}
			comment.setContent(content);
			Comment saveResult = commentRepositroy.save(comment);
			if (saveResult != null) {
				modelMap.addAttribute("message", "成功更新评论信息");
				modelMap.addAttribute("comment", saveResult);
			} else {
				modelMap.addAttribute("message", "更新评论信息失败");
			}
			return modelMap;
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 根据ID查询留言评论信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	@ApiOperation(value = "查询评论", notes = "根据ID查询评论信息")
	public ModelMap getcommentById(@PathVariable String id) {
		ModelMap modelMap = new ModelMap();
		try {
			Long idNum = Long.parseLong(id);
			Comment comment = commentRepositroy.findOne(idNum);
			if (comment == null) {
				modelMap.addAttribute("message", "要查询的评论不存在");
			}
			return modelMap.addAttribute("comment", comment);
		} catch (Exception e) {
			return modelMap.addAttribute("message", "参数不合法");
		}
	}

	/**
	 * 分页查询评论信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param sortStr
	 * @param modelMap
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "分页查询评论", notes = "分页查询评论信息")
	public ModelMap listcommentPage(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
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
		Page<Comment> commentPage = commentRepositroy.findAll(pageable);
		modelMap.addAttribute("page", commentPage);
		return modelMap;
	}

	/**
	 * 根据文章ID条件分页查询评论信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param articleId
	 * @return
	 */
	@GetMapping("articleId")
	@ApiOperation(value = "条件查询评论", notes = "根据文章ID条件分页查询评论信息")
	public ModelMap listcommentPageByArticleId(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSizeStr,
			@RequestParam(value = "articleId", required = false, defaultValue = "") String articleId) {
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
		Page<Comment> commentPage = commentRepositroy.findCommentsByArticleId(Long.parseLong(articleId), pageable);
		modelMap.addAttribute("page", commentPage);
		return modelMap;
	}

	/**
	 * 按评论名条件分页查询评论信息
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param name
	 * @return
	 */
	@GetMapping("p")
	@ApiOperation(value = "条件查询评论", notes = "按评论名条件分页查询评论信息")
	public ModelMap listcommentPageByParameter(
			@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNoStr,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") String pageSizeStr,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
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
		Page<Comment> commentPage = commentRepositroy.findCommentsByContentContains(content, pageable);
		modelMap.addAttribute("page", commentPage);
		return modelMap;
	}

}
