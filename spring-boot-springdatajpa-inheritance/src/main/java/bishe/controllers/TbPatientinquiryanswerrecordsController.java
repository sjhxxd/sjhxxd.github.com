package bishe.controllers;

import bishe.entity.TbPatientinquiryanswerrecordsEntity;
import bishe.service.TbPatientinquiryanswerrecordsService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjh on 16/4/24.
 */
@RestController
public class TbPatientinquiryanswerrecordsController {
    @Autowired
    private TbPatientinquiryanswerrecordsService tbPatientinquiryanswerrecordsService;

    @RequestMapping(value = "/inquiryanswerrecords/getall", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TbPatientinquiryanswerrecordsEntity> getInquiryAnswerRecordsAll(){
        return tbPatientinquiryanswerrecordsService.getAllInquiryAnswerRecords();
    }

    @RequestMapping(value = "/inquiryanswerrecords/findbyid/{answerRecordsId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TbPatientinquiryanswerrecordsEntity getInquiryAnswerRecordById(@PathVariable Long answerRecordsId){
        return tbPatientinquiryanswerrecordsService.findByAnswerRecordsId(answerRecordsId);
    }

    @RequestMapping(value = "/inquiryanswerrecords/saveorupdate", method = {RequestMethod.POST, RequestMethod.PUT}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveOrUpdateInquiryAnswerRecords(TbPatientinquiryanswerrecordsEntity tbPatientinquiryanswerrecordsEntity){
        try {
            tbPatientinquiryanswerrecordsService.saveOrUpdateAnswerRecords(tbPatientinquiryanswerrecordsEntity);
            return "Success";
        } catch (Exception e) {
            System.out.println("错误:" + e.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/inquiryanswerrecords/deletebyid/{answerRecordsId}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long deleteInquiryAnswerRecord(@PathVariable Long answerRecordsId){
        tbPatientinquiryanswerrecordsService.deleteAnswerRecords(answerRecordsId);
        return answerRecordsId;
    }


}
