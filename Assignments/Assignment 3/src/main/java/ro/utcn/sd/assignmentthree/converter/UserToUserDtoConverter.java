package ro.utcn.sd.assignmentthree.converter;

import ro.utcn.sd.assignmentthree.dto.UserDto;
import ro.utcn.sd.assignmentthree.entity.User;

public class UserToUserDtoConverter implements SuperConverter<User, UserDto> {
    @Override
    public UserDto apply(final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEnabled(user.isEnabled());
        return userDto;
    }
}
