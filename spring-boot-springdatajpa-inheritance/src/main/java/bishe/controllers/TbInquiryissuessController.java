package bishe.controllers;

import bishe.entity.TbInquiryissuessEntity;
import bishe.repository.TbInquiryissuessRepository;
import bishe.service.TbInquiryissuessService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/4/21.
 */
@RestController
public class TbInquiryissuessController {
    @Autowired
    private TbInquiryissuessService tbInquiryissuessService;

    @RequestMapping(value = "/inquiryissuess/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TbInquiryissuessEntity> getInquiryissuessAll(){
        return tbInquiryissuessService.getAllInquiryissuess();
    }

    @RequestMapping(value = "/inquiryissuess/findbyid/{inquiryQuestionId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TbInquiryissuessEntity getInquiryissuessById(@PathVariable Long inquiryQuestionId){
        return tbInquiryissuessService.findbyInquiryQuestionId(inquiryQuestionId);
    }

    @RequestMapping(value = "/inquiryissuess/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateInquiryissuess(TbInquiryissuessEntity tbInquiryissuessEntity){
        try {
            tbInquiryissuessService.saveOrUpdateTbInquiryissuess(tbInquiryissuessEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/inquiryissuess/deletebyid/{inquiryQuestionId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteInquiryissuess(@PathVariable Long inquiryQuestionId){
        tbInquiryissuessService.deleteByInquiryQuestionId(inquiryQuestionId);
        return inquiryQuestionId;
    }

}
