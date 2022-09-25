package com.dtshop.app.Service.ServiceImpl;

import com.dtshop.app.Domain.Role;
import com.dtshop.app.Domain.User;
import com.dtshop.app.Domain.RoleUser;
import com.dtshop.app.Dto.FunctionDto.ResponseObject;
import com.dtshop.app.Dto.FunctionDto.SearchDto;
import com.dtshop.app.Dto.RoleDto;
import com.dtshop.app.Dto.UserDto;
import com.dtshop.app.Repository.RoleRepository;
import com.dtshop.app.Repository.RoleUserRepository;
import com.dtshop.app.Repository.UserRepository;
import com.dtshop.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepos;

    @Autowired
    private RoleRepository roleRepos;

    @Autowired
    private RoleUserRepository roleUserRepos;

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<UserDto> getAllDto() {
        // get All
        return this.userRepos.getAllDto();
    }

    @Override
    public Page<UserDto> getPageDto(int pageIndex, int pageSize) {
        // Phân trang
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        return this.userRepos.getPageDto(pageable);
    }

    @Override
    public UserDto getEntity(Long id) {
        User entity = null;
        if(id != null) {
            Optional<User> userSerOptional = this.userRepos.findById(id);
            if (userSerOptional.isPresent()) {
                entity = userSerOptional.get();
                return new UserDto(entity, true);
            }
        }
        return null;
    }

    @Override
    public UserDto getUserByUsername(String username) {
        if(username != null) {
            Long number = this.userRepos.checkUsername(username);
            if(number==1) {
                return this.roleUserRepos.getUserByUsername(username);
            }
            return null;
        }
        return null;
    }

    @Override
    public UserDto createDto(Long id, UserDto dto) {
        return this.updateDto(null, dto);
    }

    @Override
    public UserDto updateDto(Long id, UserDto dto) {
        User entity = null;
        LocalDateTime dateCreate = LocalDateTime.now();
        if(id != null) {
            Optional<User> userOptional = this.userRepos.findById(id);
            if(userOptional.isPresent()) {
                entity = userOptional.get();
            }
        } else if(dto.getId() != null) {
            Optional<User> userOptional = this.userRepos.findById(dto.getId());
            if(userOptional.isPresent()) {
                entity = userOptional.get();
            }
        }
        if(entity == null) {
            entity = new User();
            entity.setDateCreate(dateCreate);
        }
        if(dto.getUsername() != null) {
            entity.setUsername(dto.getUsername());
        }
        if(dto.getPassword() != null) {
            entity.setPassword(dto.getPassword());
        }
        if(dto.getLevel() != null) {
            entity.setLevel(dto.getLevel());
        }
        if(dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
        // Lưu đồng thời sang bảng User_Role
        if(dto.getRoles() != null && dto.getRoles().size() > 0) {
            HashSet<RoleUser> roleUserDtos = new HashSet<>();
            for(RoleDto roleDto : dto.getRoles()) {
                RoleUser roleUser = new RoleUser();
                Role role = null;
                if(roleDto != null) {
                    if(roleDto.getId() != null) {
                        Optional<Role> roleOptional = this.roleRepos.findById(roleDto.getId());
                        if(roleOptional.isPresent()) {
                            role = roleOptional.get();
                        }
                    }
                }
                roleUser.setUser(entity);
                if(role != null) {
                    roleUser.setRole(role);
                }
                roleUserDtos.add(roleUser);
            }
            // Trường hợp đã có dl
            if(entity.getUserRoles() != null) {
                entity.getUserRoles().clear();
                entity.getUserRoles().addAll(roleUserDtos);
            } else {
                entity.setUserRoles(roleUserDtos);
            }
        } else {
            entity.getUserRoles().clear();
        }
        entity = this.userRepos.save(entity);
        return new UserDto(entity, true);
    }

    @Override
    public UserDto deleteDto(Long id) {
        User entity = null;
        if(id != null) {
            Optional<User> userSerOptional = this.userRepos.findById(id);
            if (userSerOptional.isPresent()) {
                entity = userSerOptional.get();
                this.userRepos.delete(entity);
                return new UserDto(entity, true);
            }
        }
        return null;
    }

    @Override
    public Page<UserDto> seachByPage(SearchDto searchDto) {
        if(searchDto != null && searchDto.getPageIndex() != null && searchDto.getPageSize() != null) {
            int pageIndex = searchDto.getPageIndex();
            int pageSize = searchDto.getPageSize();
            if(pageIndex > 0) {
                pageIndex = pageIndex - 1;
            } else {
                pageIndex = 0;
            }
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            String sql = "Select new com.dtshop.app.Dto.UserDto(entity, true) From User entity Where (1=1)";
            String sqlCount = "Select Count(entity.id) From User entity Where (1=1)";
            String orderBy = " Order by entity.dateCreate DESC";
            String whereClause = "";
            if(searchDto.getNameOrCode() != null) {
                whereClause += " And entity.username Like :textSearch ";
            }
            if(searchDto.getNumberSearch() != null) {
                whereClause += " And entity.active = :active ";
            }
            sql += whereClause + orderBy;
            sqlCount += whereClause;
            Query q = manager.createQuery(sql, UserDto.class);
            Query qCount = manager.createQuery(sqlCount);
            if(searchDto.getNameOrCode() != null) {
                q.setParameter("textSearch", "%"+searchDto.getNameOrCode()+"%");
                qCount.setParameter("textSearch", "%"+searchDto.getNameOrCode()+"%");
            }
            if(searchDto.getNumberSearch() != null) {
                q.setParameter("active", searchDto.getNumberSearch());
                qCount.setParameter("active", searchDto.getNumberSearch());
            }
            q.setFirstResult(pageIndex*pageSize);
            q.setMaxResults(pageSize);
            Long numberResult = (Long) qCount.getSingleResult();
            Page<UserDto> result = new PageImpl<>(q.getResultList(), pageable, numberResult);
            return result;
        }
        return null;
    }
}
