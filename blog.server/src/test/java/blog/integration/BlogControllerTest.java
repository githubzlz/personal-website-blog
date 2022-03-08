package blog.integration;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.common.dtos.BlogContentEditReq;
import com.zlz.website.blog.common.enums.blog.EditorTypeEnum;
import com.zlz.website.blog.common.enums.blog.ProvenanceEnum;
import com.zlz.website.blog.common.enums.category.IsPublishEnum;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

/**
 * @author zhulinzhong
 * @date 2022-03-08 16:34:15
 */
public class BlogControllerTest extends BaseTest {

    @Autowired
    private TestRestTemplate template;
    ;

    @Test
    public void blogControllerEditTest() {
        BlogEditReq req = new BlogEditReq();
        req.setTitle("标题一");
        req.setProvenance(ProvenanceEnum.ORIGINAL.getCode());
        req.setIsPublish(IsPublishEnum.PUBLISHED.getCode());
        req.setImgSrc("http://www.test.com/img");
        BlogContentEditReq editDTO = new BlogContentEditReq();
        req.setBlogContent(editDTO);

        editDTO.setEditorType(EditorTypeEnum.EDITOR_MD.getType());
        editDTO.setContent("# 标题");
        editDTO.setNote("备注");
        ResponseEntity<ResultSet> resultSetResponseEntity = template.postForEntity("/blog/edit", req, ResultSet.class);
        Assert.assertNotNull(resultSetResponseEntity);
        Assert.assertNotNull(resultSetResponseEntity.getBody());
        Assert.assertEquals(resultSetResponseEntity.getBody().getCode(), ResultSet.success().getCode());
    }

}
