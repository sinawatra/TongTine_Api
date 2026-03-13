package wing.tongtin.demo.service;

import wing.tongtin.demo.entity.TontineGroupEntity;
import wing.tongtin.demo.enumeration.GroupStatus;
import wing.tongtin.demo.repository.TontineGroupRepository;
import wing.tongtin.demo.request.CreateGroupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TontineService {

    private final TontineGroupRepository groupRepository;

    public TontineGroupEntity createGroup(CreateGroupRequest request) {

        TontineGroupEntity group = TontineGroupEntity.builder()
                .groupName(request.getGroupName())
                .contributionAmount(request.getContributionAmount())
                .totalMembers(request.getTotalMembers())
                .status(GroupStatus.PENDING)
                .build();

        return groupRepository.save(group);
    }


    public List<TontineGroupEntity> getAllGroupListing() {
        return groupRepository.findAll();
    }

    public TontineGroupEntity getGroupInFoById(String id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));
    }

}