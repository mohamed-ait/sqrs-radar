package org.sid.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T> (
        @TargetAggregateIdentifier
        open val id : T
)