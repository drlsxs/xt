package com.numberone.project.gistools.track.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.numberone.project.gistools.wms.domain.Wms;
import com.numberone.project.gistools.wms.mapper.WmsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.gistools.track.mapper.TrackMapper;
import com.numberone.project.gistools.track.domain.Track;
import com.numberone.project.gistools.track.service.ITrackService;
import com.numberone.common.utils.text.Convert;

/**
 * trackService业务层处理
 *
 * @author wly
 * @date 2022-04-01
 */
@Service
public class TrackServiceImpl extends ServiceImpl<TrackMapper, Track> implements ITrackService
{
    @Autowired
    private TrackMapper trackMapper;

    /**
     * 查询track
     *
     * @param id trackID
     * @return track
     */
    @Override
    public Track selectTrackById(String id)
    {
        return trackMapper.selectTrackById(id);
    }

    /**
     * 查询track列表
     *
     * @param track track
     * @return track
     */
    @Override
    public List<Track> selectTrackList(Track track)
    {
        return trackMapper.selectTrackList(track);
    }

    /**
     * 新增track
     *
     * @param track track
     * @return 结果
     */
    @Override
    public int insertTrack(Track track)
    {
        return trackMapper.insertTrack(track);
    }

    /**
     * 修改track
     *
     * @param track track
     * @return 结果
     */
    @Override
    public int updateTrack(Track track)
    {
        return trackMapper.updateTrack(track);
    }

    /**
     * 删除track对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTrackByIds(String ids)
    {
        return trackMapper.deleteTrackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除track信息
     *
     * @param id trackID
     * @return 结果
     */
    @Override
    public int deleteTrackById(String id)
    {
        return trackMapper.deleteTrackById(id);
    }

    @Override
    public List<Track> selectCarNo(Track track) {
        return trackMapper.selectCarNo(track);
    }


}
