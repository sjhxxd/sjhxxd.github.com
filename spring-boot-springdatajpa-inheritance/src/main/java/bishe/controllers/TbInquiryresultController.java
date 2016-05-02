package bishe.controllers;

import bishe.entity.TbInquiryresultEntity;
import bishe.repository.TbInquiryresultReopository;
import bishe.service.TbInquiryresultService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/4/23.
 */
@RestController
public class TbInquiryresultController {
    @Autowired
    private TbInquiryresultService tbInquiryresultService;

    @RequestMapping(value = "/inquiryresult/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TbInquiryresultEntity> getInquiryResultAll(){
        return tbInquiryresultService.getAllInquiryResult();
    }

    @RequestMapping(value = "/inquiryresult/findbyid/{inquiryResultId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TbInquiryresultEntity getInquiryResultById(@PathVariable Long inquiryResultId){
        return tbInquiryresultService.findByInquiryResultId(inquiryResultId);
    }

    @RequestMapping(value = "/inquiryresult/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveOrUpdateInquiryResult(TbInquiryresultEntity tbInquiryresultEntity){
        tbInquiryresultService.saveOrUpdateInquiryResult(tbInquiryresultEntity);
    }

    @RequestMapping(value = "/inquiryresult/deletebyid/{inquiryResultId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteInquiryResult(@PathVariable Long inquiryResultId){
        tbInquiryresultService.deleteByInquiryResultId(inquiryResultId);
        return inquiryResultId;
    }
}