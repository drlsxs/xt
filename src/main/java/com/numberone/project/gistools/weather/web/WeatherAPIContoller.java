package com.numberone.project.gistools.weather.web;




import com.numberone.project.gistools.weather.dto.WeatherDto;
import com.numberone.project.gistools.weather.service.WeatherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/gistools/weather")
public class WeatherAPIContoller {

    @Autowired
    WeatherManager weatherManager;
    //用来校验传参是否正确
    @Value("${city.code}")
    private String cityCode;
    /**
     * 天气数据
     * @param id
     * @return
     */
    @GetMapping(value = "/city/{id:1[0-9]{8}}")
    @ResponseBody
    public WeatherDto loadApi(@PathVariable("id") String id){
        String vliCode = String.format(",%s,", id);
        if(!cityCode.contains(vliCode)){
            throw new RuntimeException("no_city_id");
        }
        return weatherManager.getById(id);

    }
}
