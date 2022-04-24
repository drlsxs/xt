package com.numberone.project.gistools.track.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.gistools.track.domain.Track;
import com.numberone.project.gistools.track.service.ITrackService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * trackController
 *
 * @author wly
 * @date 2022-04-01
 */
@Controller
@RequestMapping("/gistools/track")
public class TrackController extends BaseController
{
    private String prefix = "gistools/track";

    @Autowired
    private ITrackService trackService;

    @RequiresPermissions("gistools:track:view")
    @GetMapping()
    public String track()
    {
        return prefix + "/track";
    }

    /**
     * 查询track列表
     */
//    @RequiresPermissions("gistools:track:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Track track)
    {
        startPage();
        List<Track> list = trackService.selectTrackList(track);
        return getDataTable(list);
    }

    @PostMapping("/carNo")
    @ResponseBody
    public TableDataInfo list1(Track track)
    {
        startPage();
        List<Track> list = trackService.selectCarNo(track);
        return getDataTable(list);
    }

    /**
     * 导出track列表
     */
//    @RequiresPermissions("gistools:track:export")
    @Log(title = "track", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Track track)
    {
        List<Track> list = trackService.selectTrackList(track);
        ExcelUtil<Track> util = new ExcelUtil<Track>(Track.class);
        return util.exportExcel(list, "track");
    }

    /**
     * 新增track
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存track
     */
//    @RequiresPermissions("gistools:track:add")
    @Log(title = "track", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody Track track)
    {
        return toAjax(trackService.insertTrack(track));
    }

    /**
     * 修改track
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public AjaxResult edit(@PathVariable("id") String id)
    {
        Track track = trackService.selectTrackById(id);
        return AjaxResult.success(track);
    }

    /**
     * 修改保存track
     */
//    @RequiresPermissions("gistools:track:edit")
    @Log(title = "track", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Track track)
    {
        return toAjax(trackService.updateTrack(track));
    }

    /**
     * 删除track
     */
//    @RequiresPermissions("gistools:track:remove")
    @Log(title = "track", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable String ids)
    {
        return toAjax(trackService.deleteTrackByIds(ids));
    }


}
