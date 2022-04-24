package com.numberone.project.gistools.track.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.numberone.project.gistools.track.domain.Track;

/**
 * trackMapper接口
 *
 * @author wly
 * @date 2022-04-01
 */
public interface TrackMapper extends BaseMapper<Track>
{
    /**
     * 查询track
     *
     * @param id trackID
     * @return track
     */
    public Track selectTrackById(String id);

    /**
     * 查询track列表
     *
     * @param track track
     * @return track集合
     */
    public List<Track> selectTrackList(Track track);

    /**
     * 新增track
     *
     * @param track track
     * @return 结果
     */
    public int insertTrack(Track track);

    /**
     * 修改track
     *
     * @param track track
     * @return 结果
     */
    public int updateTrack(Track track);

    /**
     * 删除track
     *
     * @param id trackID
     * @return 结果
     */
    public int deleteTrackById(String id);

    /**
     * 批量删除track
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTrackByIds(String[] ids);

    List<Track> selectCarNo(Track track);
}
