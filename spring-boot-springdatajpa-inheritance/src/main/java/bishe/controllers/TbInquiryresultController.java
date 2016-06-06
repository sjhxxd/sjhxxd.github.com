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
@RequestMapping(value = "/inquiryresult")
public class TbInquiryresultController {
    @Autowired
    private TbInquiryresultService tbInquiryresultService;
    @Autowired
    private TbInquiryresultReopository tbInquiryresultReopository;

    @RequestMapping(value = "getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TbInquiryresultEntity> getInquiryResultAll() {
        return tbInquiryresultService.getAllInquiryResult();
    }

    @RequestMapping(value = "findbyid/{inquiryResultId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TbInquiryresultEntity getInquiryResultById(@PathVariable Long inquiryResultId) {
        return tbInquiryresultService.findByInquiryResultId(inquiryResultId);
    }

    @RequestMapping(value = "findbyname/", params = "inquiryResult", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TbInquiryresultEntity> getInquiryResult(@RequestParam(value = "inquiryResult", required = true) String inquiryResult) {
        return tbInquiryresultReopository.findByInquiryResult(inquiryResult);
    }

    @RequestMapping(value = "saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateInquiryResult(TbInquiryresultEntity tbInquiryresultEntity) {
        try {
            tbInquiryresultService.saveOrUpdateInquiryResult(tbInquiryresultEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "deletebyid/{inquiryResultId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteInquiryResult(@PathVariable Long inquiryResultId) {
        tbInquiryresultService.deleteByInquiryResultId(inquiryResultId);
        return inquiryResultId;
    }
}
