package ro.utcn.sd.assignmentthree.converter;

import ro.utcn.sd.assignmentthree.dto.UserDto;
import ro.utcn.sd.assignmentthree.entity.User;

public class UserDtoToUserConverter implements SuperConverter<UserDto, User> {

    @Override
    public User apply(final UserDto userDto) {
        final User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setEnabled(userDto.isEnabled());
        return user;
    }
}
