package com.gvdroid.simple.demo1;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.base.component.R;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@Api(tags = "DEMO-1 Demo1")
@Slf4j
public class Server1Controller {

    @Autowired
    GDemoProperties gDemoProperties;

    @RefreshScope
    public GDemoProperties get() {
        return this.gDemoProperties;
    }

    @BusinessLogger("DEMO-1")
    @ApiOperation(value = "DEMO-1 Demo1", httpMethod = "POST")
    @PostMapping(value = "/demo/1")
    @ResponseBody
    @SneakyThrows
    public R<UserResponseDTO> inquiryUser(@Valid @RequestBody UserRequestDTO requestDTO) {

        Random random = new Random();
        int i = random.nextInt(10);
        TimeUnit.SECONDS.sleep(i);
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(this.gDemoProperties.getBbb());
        responseDTO.setDataList(this.gDemoProperties.getList());
        return R.body(responseDTO);
    }

    //    @BusinessLogger(value = "DEMO-2")
    @ApiOperation(value = "DEMO-2 Demo2", httpMethod = "POST")
    @PostMapping(value = "/demo/2")
    public void downloadFile(@Valid @RequestBody DownloadRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //声明本次下载状态的记录对象
        DownloadRecord downloadRecord = new DownloadRecord(requestDTO.getFileName(), requestDTO.getFilePath(), request);
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + requestDTO.getFileName());
        //用于记录以完成的下载的数据量，单位是byte
        long downloadedLength = 0l;
        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(requestDTO.getFilePath() + requestDTO.getFileName());
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                downloadedLength += b.length;
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e) {
            downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
            throw e;
        }
        downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
        downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
        downloadRecord.setLength(downloadedLength);
        //存储记录
    }
}
