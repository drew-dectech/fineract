package org.mifosplatform.useradministration.handler;

import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.useradministration.service.AppUserWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateUserCommandHandler implements NewCommandSourceHandler {

    private final AppUserWritePlatformService writePlatformService;

    @Autowired
    public UpdateUserCommandHandler(final AppUserWritePlatformService writePlatformService) {
        this.writePlatformService = writePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {

        final Long userId = command.entityId();
        return this.writePlatformService.updateUser(userId, command);
    }
}